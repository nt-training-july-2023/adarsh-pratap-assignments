import axios from "axios";

export const getMapping=(url,options)=>{
    return axios.get(`${process.env.REACT_APP_ENV_VARIABE}`+url,options);
}

export const postMapping=(url,value,options)=>{
    return axios.post(`${process.env.REACT_APP_ENV_VARIABE}`+url,value,options);
}

export const putMapping=(url,data,options)=>{
    return axios.put(`${process.env.REACT_APP_ENV_VARIABE}`+url,data,options);
}

export const deleteMapping=(url,options)=>{
    return axios.delete(`${process.env.REACT_APP_ENV_VARIABE}`+url,options);
}
