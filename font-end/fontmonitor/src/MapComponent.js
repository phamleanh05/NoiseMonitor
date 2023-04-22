import React from 'react';
import { Map, GoogleApiWrapper, Marker, InfoWindow } from 'google-maps-react';
import axios from 'axios';
import {Nav, Navbar, NavDropdown} from "react-bootstrap";

const SOUND_REST_API_URL = 'http://localhost:8086/api/location';

const mapStyles = {
    width: '100%',
    height: '100%'
};

class MapComponent extends React.Component {
    constructor(props) {
        super(props);
        this.onMarkerClick = this.onMarkerClick.bind(this);
        this.toggleMarkers = this.toggleMarkers.bind(this);
        this.state = {
            location: [],
            activeMarker: null,
            selectedLocation: null,
            showingInfoWindow: false,
            showNullMarkers: true
        };
    }

    componentDidMount() {
        this.fetchLocations();
    }

    fetchLocations() {
        axios.get(SOUND_REST_API_URL)
            .then(response => {
                this.setState({ location: response.data });
            })
            .catch(error => {
                console.error(error);
            });
    }

    onMarkerClick = (props, marker) => {
        this.setState({
            activeMarker: marker,
            selectedLocation: props.location,
            showingInfoWindow: true
        });
    }

    onClose = () => {
        this.setState({
            activeMarker: null,
            selectedLocation: null,
            showingInfoWindow: false
        });
    }

    toggleMarkers() {
        this.setState({ showNullMarkers: !this.state.showNullMarkers });
    }

    render() {
        return (
            <div>
                <Navbar  bg="dark" variant="dark" className="justify-content-center">
                    <Navbar.Brand href="#">NOISE MONITOR</Navbar.Brand>
                        <Nav className="mr-auto">
                            <Nav.Link onClick={this.toggleMarkers}>
                                {this.state.showNullMarkers ? 'ON' : 'OFF'} Old Location
                            </Nav.Link>
                        </Nav>
                </Navbar>
            <div >
                <Map google={this.props.google}
                     zoom={12}
                     style={mapStyles}
                     initialCenter={{
                         lat: 10.762622,
                         lng: 106.660172
                     }}>
                    {this.state.location.map(location => {
                        if (!this.state.showNullMarkers && !location.soundId) {
                            return null;
                        }
                        const iconUrl = location.soundId
                            ? 'http://maps.google.com/mapfiles/ms/icons/green-dot.png'
                            : 'http://maps.google.com/mapfiles/ms/icons/red-dot.png';
                        return (
                            <Marker
                                key={location.locationId}
                                position={{ lat: location.lat, lng: location.lng }}
                                location={location}
                                onClick={() => window.location.href=`/detail/${location.soundId}`}
                                title={`Node ${location.soundId || '(null)'}`}
                                icon={iconUrl}
                            />
                        );
                    })}
                    <InfoWindow
                        marker={this.state.activeMarker}
                        visible={!!this.state.activeMarker}
                        onClose={this.onClose}>
                    </InfoWindow>
                </Map>
            </div>
            </div>
        );
    }
}

export default GoogleApiWrapper(
    (props) => ({
        apiKey: props.apiKey
    })
)(MapComponent);
