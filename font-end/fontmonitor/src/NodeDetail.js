import React, { Component } from 'react';
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend } from 'recharts';
import axios from 'axios';
import {useParams} from "react-router-dom";

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
        axios.get(`${SOUND_REST_API_URL}${nodeId}`)
            .then(response => {
                this.setState({ sound: [response.data] }); // Set state to an array containing the single object
            })
            .catch(error => {
                console.error(error);
            });
    }

    render() {

        return (
            <div>
                <h1 className="text-center">Details Node</h1>
                <table className="table table-striped">
                    <thead>
                    <tr>
                        <td>Sound id</td>
                        <td>Sound decibels</td>
                        <td>Sound area</td>
                        <td>Sound latitude</td>
                        <td>Sound longitude</td>
                        <td>Time</td>
                    </tr>
                    </thead>
                    <tbody>
                    {this.state.sound.map(sound => (
                        <tr key={sound.id}>
                            <td>{sound.id}</td>
                            <td>{sound.decibels}</td>
                            <td>{sound.area}</td>
                            <td>{sound.lat}</td>
                            <td>{sound.lng}</td>
                            <td>{sound.time}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        );
    }
}

export default NodeDetail;
