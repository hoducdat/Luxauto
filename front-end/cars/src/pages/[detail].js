import React, { useEffect, useState } from "react";
import { useLocation } from "react-router";
import { getItem, postContactForm } from "../api";
import "../css/Detail.css";
import { PaperPlaneIcon } from "../images";
import Footer from "./CarsStock/components/Footer";
import Header from "./CarsStock/components/Header";
import Loading from "./CarsStock/components/Loading";

const Detail = ({ props }) => {
  const location = useLocation();

  const [formInput, setFormInput] = useState({
    name: "",
    email: "",
    phone_number: "",
  });

  const [dataItem, setDataItem] = useState({
    id: "",
    title: "",
    thumbnail: "",
    description: "",
  });

  const onChangeForm = (event) => {
    let name = event.target.name || "";
    let value = event.target.value || "";
    setFormInput({
      ...formInput,
      [name]: value,
    });
  };

  const onSubmit = () => {
    postContactForm({
      ...formInput,
      auto_cars_item_id: dataItem.id || "",
    })
      .then((response) => {
        alert("success");
        window.location.reload();
      })
      .catch((err) => {
        alert("Please recheck your info");
      });
  };

  useEffect(() => {
    let uid = location.pathname.toString().replace("/detail/", "");
    getItem({ uid: uid || "" })
      .then((response) => setDataItem(response.responseData))
      .catch((err) => console.log(err));
  }, []);

  return dataItem ? (
    <div className="detailRoot">
      <Header isShowTab={false} />
      <div className="detailContainer">
        <div className="detailContent">
          <p className="itemDetailName">{dataItem.title || ""}</p>
          <div
            className="htmlContent"
            dangerouslySetInnerHTML={{
              __html: dataItem.content && dataItem.content,
            }}
          ></div>
        </div>
        <form
          className="submitForm"
          onSubmit={(event) => {
            event.preventDefault();
            onSubmit(event);
          }}
        >
          <div
            style={{
              display: "flex",
              alignItems: "center",
            }}
          >
            <PaperPlaneIcon className="paperPlaneIcon" />
            <p className="formTitle">Li??n H???</p>
          </div>
          <p className="formInstruction">
            Vui l??ng ??i???n ?????y ????? th??ng tin li??n h??? v??o form
          </p>
          <p className="formLabel">
            H??? v?? t??n <span className="requiredIcon">&#42;</span>
          </p>
          <input
            className="formInput"
            id="name"
            name="name"
            onChange={onChangeForm}
          />
          <p className="formLabel">
            Email <span className="requiredIcon">&#42;</span>
          </p>
          <input
            className="formInput"
            id="email"
            name="email"
            onChange={onChangeForm}
            type="email"
          />
          <p className="formLabel">
            S??? ??i???n tho???i <span className="requiredIcon">&#42;</span>
          </p>
          <input
            className="formInput"
            id="phone"
            name="phone_number"
            onChange={onChangeForm}
            type="phone"
          />
          <p className="requireIconExplain">&#42; : b???t bu???c</p>
          <button className="submitButton">G???i ??i</button>
        </form>
      </div>
      <Footer />
    </div>
  ) : (
    <Loading />
  );
};

Detail.propTypes = {};

export default Detail;
