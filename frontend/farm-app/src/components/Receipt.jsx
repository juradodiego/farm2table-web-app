import React, { useState } from "react";
import "../style/receipt.scss";

function Receipt() {
  const [modal, setModal] = useState(false);
  const [list, setList] = useState([
    { id: 1 },
    { id: 2 },
    { id: 3 },
    { id: 4 },
  ]);
  const toggleModal = () => {
    setModal(!modal);
  };

  if (modal) {
    document.body.classList.add("active-modal");
  } else {
    document.body.classList.remove("active-modal");
  }

  const deleteItem = (id) => {
    const newList = list.filter((item) => item.id !== id);
    setList(newList);
  };

  const addItem = () => {
    const newList = [...list];
    const newId = list.length > 0 ? list[list.length - 1].id + 1 : 1;
    newList.push({ id: newId });
    setList(newList);
  };

  const approve = () => {
    setModal(!modal);
  };

  return (
    <>
      <button onClick={toggleModal} className="btn-modal">
        Finish Conversation
      </button>

      {modal && (
        <div className="modal">
          <div onClick={toggleModal} className="overlay"></div>
          <div className="modal-content">
            <h2>Receipt</h2>
            <div className="receiptContents">
              <p>Produce:</p>
              <p>Amount:</p>
              <p>Price:</p>
            </div>
            <div className="singleItem">
              {list.map((item) => (
                <div className="receiptContents" key={item.id}>
                  <input className="test" type="text" readOnly />
                  <input className="test" type="text" readOnly />
                  <input className="test" type="text" readOnly />
                  <button onClick={() => deleteItem(item.id)}>delete</button>
                </div>
              ))}
            </div>
            <button className="buttons" onClick={approve}>
              Approve
            </button>
            <button className="buttons">Edit</button>
            <button className="buttons" onClick={() => addItem()}>
              Add
            </button>
            <button className="buttons">Save</button>
            <button className="close-modal" onClick={toggleModal}>
              CLOSE
            </button>
          </div>
        </div>
      )}
    </>
  );
}

export default Receipt;
