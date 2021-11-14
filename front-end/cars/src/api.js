import axios from "axios";
import { ApiConstant } from "./const";
import { format as StringFormat } from "react-string-format";

export async function getItemList(data) {
  const response = await axios.get(ApiConstant.ITEM_LIST, {
    params: {
      ...data,
    },
  });
  return { response: response.data, responseData: response.data.data };
}

export async function getItem(data) {
  const response = await axios.get(
    StringFormat(ApiConstant.ITEM, data.uid || ""),
    { ...data }
  );
  return { response: response.data, responseData: response.data.data };
}

export async function postContactForm(data) {
  const response = await axios.post(ApiConstant.CUSTOMER, { ...data });
  return { response: response.data, responseData: response.data.data };
}
