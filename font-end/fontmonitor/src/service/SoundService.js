import axios from 'axios'

const SOUND_REST_API_URL = 'http://localhost:8086/api/sound';

class SoundService {
    getSound(){
        axios.get(SOUND_REST_API_URL);
    }
}

export default new SoundService()