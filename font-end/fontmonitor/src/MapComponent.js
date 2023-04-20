import React from 'react';
import { Map, GoogleApiWrapper, Marker, InfoWindow } from 'google-maps-react';
import axios from 'axios';
const SOUND_REST_API_URL = 'http://localhost:8086/api/sound';

const mapStyles = {
    width: '100%',
    height: '100%'
};

class MapComponent extends React.Component {

    constructor(props) {
        super(props);
        this.onMarkerClick = this.onMarkerClick.bind(this);
        this.state = {
            sound: [],
            activeMarker: null,
            selectedLocation: null,
            showingInfoWindow: false,
        };
    }

    componentDidMount() {
        this.fetchLocations();
    }

    fetchLocations() {
        axios.get(SOUND_REST_API_URL)
            .then(response => {
                this.setState({ sound: response.data });
            })
            .catch(error => {
                console.error(error);
            });
    }

    onMarkerClick = (props, marker) => {
        this.setState({
            activeMarker: marker,
            selectedLocation: props.sound,
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

    render() {
        return (
            <Map google={this.props.google}
                 zoom={12}
                 style={mapStyles}
                 initialCenter={
                     {
                         lat: 10.762622,
                         lng: 106.660172
                     }
                 }>
                {this.state.sound.map(sound => (
                    <Marker
                        key={sound.id}
                        position={{ lat: sound.lat, lng: sound.lng }}
                        location={sound}
                        onClick={() => window.location.href=`/detail/${sound.id}`}
                        title={'node '+ sound.id}
                    />
                ))}
                <InfoWindow
                    marker={this.state.activeMarker}
                    visible={!!this.state.activeMarker}
                    onClose={this.onClose}>
                </InfoWindow>
            </Map>
        );
    }
}

export default GoogleApiWrapper(
    (props) => ({
            apiKey: props.apiKey
        }
    ))(MapComponent)