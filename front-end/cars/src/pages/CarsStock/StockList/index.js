import React from "react";
import "../../../css/StockList.css";
import PropTypes from "prop-types";
import StockListItem from "../components/StockListItem";

const StockList = ({ data }) => {
  return (
    <div className="stockBody">
      <div className="stockGrid">
        {data?.map((item) => (
          <StockListItem data={item} />
        ))}
      </div>
    </div>
  );
};

StockList.propTypes = {
  data: PropTypes.array,
};

StockList.defaultProps = {
  data: [],
};

export default StockList;
