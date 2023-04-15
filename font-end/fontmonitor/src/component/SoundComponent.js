import React from 'react';
import SoundService from '../service/SoundService';
import soundService from "../service/SoundService";

class SoundComponent extends React.Component {
    constructor() {
        super();
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
            <div></div>
        )
    }
}

export default new SoundComponent()