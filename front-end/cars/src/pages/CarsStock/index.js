import React, { useEffect, useState } from "react";
import Footer from "./components/Footer";
import StockList from "./StockList";
import Header from "./components/Header";
import { getItemList } from "../../api";
import { AppConstant } from "../../const";
import Loading from "./components/Loading";

const CarsStock = () => {
  const [selectedTab, setSelectedTab] = useState(1);
  const [isShowLoading, setIsShowLoading] = useState(false);
  const [stockListData, setStockListData] = useState({
    inStockList: [],
    soldList: [],
  });
  const [filter, setFilter] = useState("");

  useEffect(() => {
    setIsShowLoading(true);
    setTimeout(() => {
      let requestBody = {
        published: selectedTab,
      };
      if (filter) requestBody = { ...requestBody, filter: filter };
      getItemList(requestBody)
        .then((response) => {
          if (selectedTab === AppConstant.ITEM_AVAILABLE_STATE.inStock) {
            setStockListData({
              ...stockListData,
              inStockList: response?.responseData,
            });
          } else {
            setStockListData({
              ...stockListData,
              soldList: response?.responseData,
            });
          }
        })
        .catch((err) => console.log(err));
      setIsShowLoading(false);
    }, 1000);
  }, [selectedTab, filter]);

  return (
    <>
      {isShowLoading && <Loading />}
      <div className="carStockRoot" id="carStockRoot">
        <Header
          onChangeTab={setSelectedTab}
          onChangeFilter={setFilter}
          containerId="carStockRoot"
          inStock={
            selectedTab === AppConstant.ITEM_AVAILABLE_STATE.inStock
              ? stockListData.inStockList?.length
              : stockListData.soldList?.length
          }
        />
        <StockList
          selectedTab={selectedTab}
          data={
            selectedTab === AppConstant.ITEM_AVAILABLE_STATE.inStock
              ? stockListData.inStockList
              : stockListData.soldList
          }
        />
        <Footer />
      </div>
    </>
  );
};

export default CarsStock;

const MOCK_DATA = [
  {
    id: 4,
    category_list: [
      {
        id: 1,
        title: "Pinky",
      },
    ],
    price: 100000,
    title: "Pink Eel",
    thumbnail: "",
    created: 1634427101,
  },
  {
    id: 4,
    category_list: [
      {
        id: 1,
        title: "Pinky",
      },
    ],
    price: 100000,
    title: "Pink Eel",
    thumbnail: "",
    created: 1634427101,
  },
  {
    id: 4,
    category_list: [
      {
        id: 1,
        title: "Pinky",
      },
    ],
    price: 100000,
    title: "Pink Eel",
    thumbnail: "",
    created: 1634427101,
  },
  {
    id: 4,
    category_list: [
      {
        id: 1,
        title: "Pinky",
      },
    ],
    price: 100000,
    title: "Pink Eel",
    thumbnail: "",
    created: 1634427101,
  },
  {
    id: 4,
    category_list: [
      {
        id: 1,
        title: "Pinky",
      },
    ],
    price: 100000,
    title: "Pink Eel",
    thumbnail: "",
    created: 1634427101,
  },
  {
    id: 4,
    category_list: [
      {
        id: 1,
        title: "Pinky",
      },
    ],
    price: 100000,
    title: "Pink Eel",
    thumbnail: "",
    created: 1634427101,
  },
  {
    id: 4,
    category_list: [
      {
        id: 1,
        title: "Pinky",
      },
    ],
    price: 100000,
    title: "Pink Eel",
    thumbnail: "",
    created: 1634427101,
  },
];

const MOCK_SOLD_DATA = [
  {
    id: 4,
    category_list: [
      {
        id: 1,
        title: "Pinky",
      },
      {
        id: 1,
        title: "Pinky",
      },
      {
        id: 1,
        title: "Pinky",
      },
    ],
    price: 100000,
    title: "Pink Eel",
    thumbnail: "",
    created: 1634427101,
  },
  {
    id: 4,
    category_list: [
      {
        id: 1,
        title: "Pinky",
      },
    ],
    price: 100000,
    title: "Pink Eel",
    thumbnail: "",
    created: 1634427101,
  },
  {
    id: 4,
    category_list: [
      {
        id: 1,
        title: "Pinky",
      },
    ],
    price: 100000,
    title: "Pink Eel",
    thumbnail: "",
    created: 1634427101,
  },
  {
    id: 4,
    category_list: [
      {
        id: 1,
        title: "Pinky",
      },
    ],
    price: 100000,
    title: "Pink Eel",
    thumbnail: "",
    created: 1634427101,
  },
  {
    id: 4,
    category_list: [
      {
        id: 1,
        title: "Pinky",
      },
    ],
    price: 100000,
    title: "Pink Eel",
    thumbnail: "",
    created: 1634427101,
  },
  {
    id: 4,
    category_list: [
      {
        id: 1,
        title: "Pinky",
      },
    ],
    price: 100000,
    title: "Pink Eel",
    thumbnail: "",
    created: 1634427101,
  },
];
