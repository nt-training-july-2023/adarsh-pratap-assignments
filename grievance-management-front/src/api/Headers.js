export const headers=()=>{
    const header = {
        email : JSON.parse(localStorage.getItem("user")).email,
        password : localStorage.getItem("password")
    }
    return header;
}
