import React, { useEffect, useState } from "react";
import PropTypes from "prop-types";
import "../../../css/StockItem.css";
import { format as StringFormat } from "react-string-format";
import { useHistory } from "react-router";
import { PathConstant } from "../../../const";
import { convertTimeStampToDate } from "../../../util";

const StockListItem = ({ data, isSold }) => {
  const history = useHistory();

  const [isHovered, setIsHovered] = useState(false);

  let isShowBottomDetail = data.kilometered || data.created || data.gearType;

  const goToItem = () => {
    history.push(StringFormat(PathConstant.PATH_DETAIL, data.id));
  };

  return (
    <div className="stockItemRoot" onClick={goToItem}>
      <div
        className="stockItemImageContainer"
        onMouseEnter={() => setIsHovered(true)}
        onMouseLeave={() => setIsHovered(false)}
      >
        {isHovered && <div className="itemImageHoverCover" />}
        <img
          className="stockItemImg"
          alt="stock_item"
          src={
            data.thumbnail ||
            "https://scontent.fhan5-7.fna.fbcdn.net/v/t1.6435-9/186495097_2917500555233632_2825070868776307837_n.jpg?_nc_cat=100&ccb=1-5&_nc_sid=e3f864&_nc_ohc=wiEnMz7DxPEAX-KywvB&tn=GMCpt-d55xPCR5Y9&_nc_ht=scontent.fhan5-7.fna&oh=d4a6fd290221899102efd10377603720&oe=618C88D0"
          }
        />
      </div>
      <div className="nameAndPrice">
        <p className="itemName">{data.title}</p>
        {Boolean(data.price) && (
          <div className="itemPriceContainer">
            <p className={`itemPrice ${isSold && "itemSold"}`}>
              {isSold ? "Đã bán" : data.price + " đ"}
            </p>
          </div>
        )}
      </div>
      <div className="categoryContainer">
        {data.category_list.map((category, index) => (
          <>
            <p className="category"> {category.title}</p>
            {index < data.category_list.length - 1 && (
              <div className="categoryDivider" />
            )}
          </>
        ))}
      </div>
      <div className="divider" />
      {isShowBottomDetail && (
        <div className="typeAndStat">
          {data.kilometered && (
            <p className="kilometered">{data.kilometered}</p>
          )}
          {data.created && (
            <p className="virginYear">
              {convertTimeStampToDate(data.created).toLocaleDateString("vi-VI")}
            </p>
          )}
          {data.gearType && <p className="gearDiversity">{data.gearType}</p>}
        </div>
      )}
    </div>
  );
};

StockListItem.propTypes = {
  data: PropTypes.shape({
    title: PropTypes.string,
    kilometered: PropTypes.string,
    gearType: PropTypes.string,
    id: PropTypes.number,
    created: PropTypes.number,
    price: PropTypes.number,
    category_list: PropTypes.array,
  }),
  isSold: PropTypes.bool,
};

StockListItem.defaultProps = {
  data: {
    title: "",
    price: 0,
    kilometered: "",
    created: 0,
    gearType: "",
    id: 0,
    category_list: [],
  },
  isSold: false,
};

export default StockListItem;
