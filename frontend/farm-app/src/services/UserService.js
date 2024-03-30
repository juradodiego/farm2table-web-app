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

export const register = async (fName, lName, isConsumer, email, 
    password, farmName, listOfProduce, addressLine, cityName, 
    stateName, zipcode) => {
    const config = {
        method: "post",
        url: "/register",
        headers: {
            "Content-Type": "application/json"
        },
        params: {
            user: {
                fName: fName,
                lName: lName,
                consumer: isConsumer,
                email: email,
                password: password,
            },
            farm: {
                farmName: farmName,
                selling: listOfProduce,
            },
            address: {
                addressLine: addressLine,
                city: cityName,
                state: stateName,
                zipcode: zipcode, 
            }
        },
    };

    try {
        const res = await axiosInstance(config);
        return res?.data;
    } catch (err) {
        return {};
    }

}

