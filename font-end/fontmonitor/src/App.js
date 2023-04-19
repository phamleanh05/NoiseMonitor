import React from 'react';
import logo from './logo.svg';
import './App.css';
import MapComponent from "./MapComponent";
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import NodeDetail from "./NodeDetail";

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<MapComponent />} />
                <Route path="/detail/:id" element={<NodeDetail />} />
            </Routes>
        </Router>
    );
}

export default App;
