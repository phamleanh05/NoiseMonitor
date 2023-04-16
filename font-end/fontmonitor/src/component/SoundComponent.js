import React from 'react';
import SoundService from '../service/SoundService';
import soundService from "../service/SoundService";

class SoundComponent extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            sound:[]
        }
    }

    componentDidMount() {
        soundService.getSound().then((response) => {
            this.setState({sound:response.data})
        });
    }

    render() {
        return(
            <div>
                <h1 class= "text-center">Sound List</h1>
                <table className= "table table-striped">
                    <thead>
                    <tr>

                        <td>Sound id</td>
                        <td>Sound decibels</td>
                        <td>Sound area</td>
                        <td>Sound latitude</td>
                        <td>Sound longitude</td>\
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
        )
    }
}

export default SoundComponent