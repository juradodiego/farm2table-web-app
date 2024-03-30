import axiosInstance from "./AxiosInstance";

export const login = async (username, password) => {
    const config = {
        method: "post",
        url: "/user/login",
        headers: {
            "Content-Type": "application/json",
        },
        data: {loginRequest: {username: username, password: password}}
    };

    try {
        const response = await axiosInstance(config);
        return response.data; // Assuming the server returns some data upon successful login
    } catch (error) {
        // Handle error
        console.error('Error:', error);
        throw error; // Rethrow the error for handling in the calling code
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

