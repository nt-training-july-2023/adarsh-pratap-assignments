export const headers=()=>{
    const header = {
        email : JSON.parse(localStorage.getItem("data")).email,
        password : localStorage.getItem("password")
    }
    return header;
}
