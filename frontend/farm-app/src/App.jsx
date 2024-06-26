import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./style/style.scss";

import Login from "./pages/Login";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import Register from "./pages/Register";
import Messages from "./pages/Messages";
import SearchPage from "./pages/SearchPage";
import Settings from "./pages/Settings";
import PastReceipts from "./pages/PastReceipts";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/messages" element={<Messages />} />
        <Route path="/search" element={<SearchPage />} />
        <Route path="/settings" element={<Settings />} />
        <Route path="/pastReceipts" element={<PastReceipts />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
