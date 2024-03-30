import React from "react";
import { useNavigate, Link } from "react-router-dom";
import PastReceipt from "../components/PastReceipt";

const PastReceipts = () => {
  const navigate = useNavigate();
  const goToSearch = () => {
    navigate("/search");
  };
  return (
    <div className="containerV2">
      <h1>Past Receipts</h1>
      <button onClick={goToSearch}> Back</button>
      <PastReceipt />
      <PastReceipt />
      <PastReceipt />
      <PastReceipt />
    </div>
  );
};

export default PastReceipts;
