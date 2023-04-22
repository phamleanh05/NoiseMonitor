import React, { Component } from 'react';
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend } from 'recharts';
import axios from 'axios';
import { Navbar, Nav, NavDropdown } from 'react-bootstrap';

const SOUND_REST_API_URL = 'http://localhost:8086/api/sound/';

class NodeDetail extends Component {
    constructor(props) {
        super(props);
        this.state = {
            sound: []
        };
    }

    componentDidMount() {
        this.fetchData();
    }

    fetchData() {
        const nodeId = window.location.pathname.split('/').pop();
        axios.get(`${SOUND_REST_API_URL}`)
            .then(response => {
                this.setState({ sound: response.data }); // Set state to an array containing the single object
            })
            .catch(error => {
                console.error(error);
            });
    }

    render() {
        return (
            <div>
                <Navbar  bg="dark" variant="dark">
                    <Navbar.Brand href="#">NOISE MONITOR</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="mr-auto">
                            <Nav.Link href="/">Home</Nav.Link>
                            <Nav.Link href="#">About</Nav.Link>
                            <NavDropdown title="Dropdown" id="basic-nav-dropdown">
                                <NavDropdown.Item href="#">Action</NavDropdown.Item>
                                <NavDropdown.Item href="#">Another action</NavDropdown.Item>
                                <NavDropdown.Item href="#">Something else</NavDropdown.Item>
                                <NavDropdown.Divider />
                                <NavDropdown.Item href="#">Separated link</NavDropdown.Item>
                            </NavDropdown>
                        </Nav>
                    </Navbar.Collapse>
                </Navbar>
            <div style={{ backgroundColor: 'white', color: 'black', justifyContent: 'center' }}>
                <h1 className="text-center">Details Node</h1>
                <div style={{ display: 'flex', justifyContent: 'center' }}>
                    <LineChart width={800} height={400} data={this.state.sound}>
                        <Line type="monotone" dataKey="decibels" stroke="red" color="black" />
                        <CartesianGrid/>
                        <XAxis dataKey="time" />
                        <YAxis />
                        <Tooltip />
                        <Legend />
                    </LineChart>
                </div>
                <table className="table table-striped">
                    <thead>
                    <tr>
                        <td>Sound id</td>
                        <td>Sound decibels</td>
                        <td>Sound Location</td>
                        <td>Time</td>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.sound.map(sound => (
                        <tr key={sound.soundId}>
                            <td>{sound.soundId}</td>
                            <td>{sound.decibels}</td>
                            <td>{sound.locationId}</td>
                            <td>{sound.time}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
            </div>
        );
    }
}

export default NodeDetail;