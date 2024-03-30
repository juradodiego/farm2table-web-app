import axiosInstance from "./AxiosInstance";

export const login = async (username, password) => {
    const config = {
        method: "get",
        url: "/login",
        headers: {
            "Content-Type": "application/json",
        },
        params: {
            username: username,
            password: password
        },
    };

    try {
        const res = await axiosInstance(config);
        return res?.data;
    } catch (err) {
        return {};
    }
};

export const register = async (isFarmer, first, last, username, password, location, produce) => {
    const config = {
        method: "post",
        url: "/register",
        headers: {
            "Content-Type": "application/json"
        },
        params: {
            isFarmer: isFarmer,
            firstName: first,
            lastName: last,
            username: username,
            password: password,
            location: location,
            produce: produce
        },
    };

    try {
        const res = await axiosInstance(config);
        return res?.data;
    } catch (err) {
        return {};
    }

}

