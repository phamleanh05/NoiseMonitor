import React, { Component } from 'react';
import axios from 'axios';
import { useParams } from "react-router-dom";

const SOUND_REST_API_URL = 'http://localhost:8086/api/sound';

class NodeDetail extends Component {

    constructor(props) {
        super(props);

        this.state = {
            sound:[],
        };
    }

    componentDidMount() {
        axios.get(`${SOUND_REST_API_URL}/1`)
            .then(response => {
                this.setState({ sound: response.data });
            })
            .catch(error => {
                console.error(error);
            });
    }

    render() {
        const { sound } = this.state;

        return (
            <div>
                <h1 className="text-center">Details for Sound Node {sound.id}</h1>
                <table className="table table-striped">
                    <thead>
                    <tr>
                        <th>Sound ID</th>
                        <th>Decibels</th>
                        <th>Area</th>
                        <th>Latitude</th>
                        <th>Longitude</th>
                        <th>Time</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>{sound.id}</td>
                        <td>{sound.decibels}</td>
                        <td>{sound.area}</td>
                        <td>{sound.lat}</td>
                        <td>{sound.lng}</td>
                        <td>{sound.time}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        );
    }
}

export default NodeDetail;
