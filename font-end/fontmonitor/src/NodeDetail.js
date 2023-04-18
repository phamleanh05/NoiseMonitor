import React, { Component } from 'react';
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend } from 'recharts';
import axios from 'axios';

class NodeDetail extends Component {
    constructor(props) {
        super(props);

        this.state = {
            sound:[],
        };
    }

    componentDidMount() {
        this.fetchData();
    }

    fetchData() {
        // Make API request to fetch data for the selected area
        axios.get(`http://localhost:8086/api/sound/${this.state.sound.id}`)
            .then(response => {
                this.setState({ data: response.data });
            })
            .catch(error => {
                console.error(error);
            });
    }

    render() {
        return (
            <div>
                <h1 className="text-center">Details Node + {this.state.sound.id}</h1>
                <table className="table table-striped">
                    <thead>
                    <tr>

                        <td>Sound id</td>
                        <td>Sound decibels</td>
                        <td>Sound area</td>
                        <td>Sound latitude</td>
                        <td>Sound longitude</td>
                        \
                        <td>Time</td>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.sound.map(
                            sound =>
                                <tr key={sound.id}>
                                    <td>{sound.id}</td>
                                    <td>{sound.decibels}</td>
                                    <td>{sound.area}</td>
                                    <td>{sound.lat}</td>
                                    <td>{sound.lng}</td>
                                    <td>{sound.time}</td>
                                </tr>
                        )
                    }
                    </tbody>
                </table>
            </div>
        );
    }
}

export default NodeDetail