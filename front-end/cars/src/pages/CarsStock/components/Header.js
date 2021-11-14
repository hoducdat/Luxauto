/* eslint-disable react-hooks/exhaustive-deps */
/* eslint-disable jsx-a11y/anchor-is-valid */
import React, { useEffect, useState } from "react";
import PropTypes from "prop-types";
import "../../../css/Header.css";
import { goHome } from "../../../util";

function Header({
  inStock,
  onChangeTab,
  onChangeFilter,
  containerId,
  isShowTab,
}) {
  const [selectedTab, setSelectedTab] = useState(1);
  const [searchValue, setSearchValue] = useState("");

  let scrollEl = document.querySelector("#" + containerId);
  let header = document.querySelector("#" + STICKY_HEADER_ID);

  const onSearch = () => {
    onChangeFilter(searchValue);
  };

  const scrollControl = () => {
    if (isShowTab) {
      let sticky = header.offsetTop;
      if (scrollEl.scrollTop > sticky) {
        header.style.setProperty("position", "fixed");
        header.style.setProperty("top", 0);
        header.style.setProperty("background-color", "#62c7c0");
        header.style.setProperty("width", window.innerWidth - 400 + "px");
      } else {
        header.style.removeProperty("position");
        header.style.removeProperty("top");
        header.style.removeProperty("background-color");
        header.style.removeProperty("width");
      }
    }
  };

  useEffect(() => {
    onChangeTab(selectedTab);
  }, [selectedTab]);

  useEffect(() => {
    if (isShowTab && header) scrollControl();
  }, [window.innerWidth]);

  useEffect(() => {
    let numberExecuting = 1;
    const addEventScroll = () => {
      if (scrollInterval) {
        header = document.querySelector("#" + STICKY_HEADER_ID);
        scrollEl = document.getElementById(containerId);
        if (scrollEl && header) {
          scrollEl.addEventListener("scroll", scrollControl);
          clearInterval(scrollInterval);
        }
        if (numberExecuting > 100) {
          clearInterval(scrollInterval);
        }
        numberExecuting++;
      }
    };

    var scrollInterval = setInterval(addEventScroll, 1500);

    // When close this screen, reset function
    return () => {
      clearInterval(scrollInterval);
    };
  }, [containerId, header, scrollEl]);

  return (
    <div className="rootHeader">
      <div className="stockHeader">
        <img
          onClick={goHome}
          className="logo"
          alt="logo"
          src="https://drive.google.com/uc?id=1yxCJNJ4PPjKhbQWYNLCKLUcG3qPckHMF&export=download"
        />
        <h1 className="brandName">LUX AUTO</h1>
      </div>
      {isShowTab && (
        <div className="stickyHeader" id={STICKY_HEADER_ID}>
          <div className="tabContainer">
            <button
              className={`tab ${selectedTab ? "tabActive" : "tabUnActive"}`}
              onClick={() => setSelectedTab(1)}
            >
              Xe đã qua sử dụng
            </button>
            <button
              className={`tab ${selectedTab ? "tabUnActive" : "tabActive"}`}
              onClick={() => setSelectedTab(0)}
            >
              Xe đã bán
            </button>
            <p className="available">
              Available: <span className="amount">&nbsp;{inStock}</span>
            </p>
          </div>
          <div className="searchContainer">
            <input
              className="searchInput"
              onChange={(event) => setSearchValue(event.target.value)}
              onKeyDown={(event) => {
                if (event.key === "Enter" || event.keyCode === 13) onSearch();
              }}
            />
            <i className="fa fa-search searchIcon" onClick={onSearch} />
          </div>
        </div>
      )}
    </div>
  );
}

Header.propTypes = {
  isShowTab: PropTypes.bool,
  inStock: PropTypes.number,
  onChangeTab: PropTypes.func,
  onChangeFilter: PropTypes.func,
};

Header.defaultProps = {
  isShowTab: true,
  inStock: 0,
  onChangeTab: () => {},
  onChangeFilter: () => {},
};

const STICKY_HEADER_ID = "sticky_header";

export default Header;
