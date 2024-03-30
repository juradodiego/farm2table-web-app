import React from "react";
import "../style/search.scss";

const SearchPage = () => {
  return (
    <form action="">
      <div className="search-container">
        <input type="text" id="searchField1" placeholder="Location" />
        <select name="" id="">
          <option value="">Strawberry</option>
          <option value="">Strawberry</option>
          <option value="">Strawberry</option>
          <option value="">Strawberry</option>
          <option value="">Strawberry</option>
          <option value="">Strawberry</option>
          <option value="">Strawberry</option>
        </select>
        <button type="button" onclick="search()">
          Search
        </button>
      </div>
    </form>
  );
};

export default SearchPage;
