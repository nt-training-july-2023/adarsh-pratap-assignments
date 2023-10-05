export const doLogin = (user,next) =>{
    localStorage.setItem("user",JSON.stringify(user));
    next()
};

export const isLoggedIn =()=>{
    let user = localStorage.getItem("user");
    if(user == null){
        return false;
    }else{
        return true;
    }
};

export const doLogout =(next)=>{
    localStorage.removeItem("user");
    next()
}

export const getCurrentUserDetails = () =>{
    if(isLoggedIn()){
        return JSON.parse(localStorage.getItem("user"));
    }else{
        return undefined;
    }
}