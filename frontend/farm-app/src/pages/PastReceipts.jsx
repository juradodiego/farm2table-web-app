import React from "react";
import { useNavigate, Link } from "react-router-dom";

const PastReceipts = () => {
  const navigate = useNavigate();
  const goToSearch = () => {
    navigate("/search");
  };
  return (
    <div>
      <p>This is the receipts</p>
      <button onClick={goToSearch}> Back</button>
    </div>
  );
};

export default PastReceipts;
