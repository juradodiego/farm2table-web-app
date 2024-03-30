import axiosInstance from "./AxiosInstance";

// queryByProduce
export const produce = async(produce) => {
    const config = {
        method: "get",
        url: "/chat/produce",
        headers: {
            "Content-Type": "application/json",
        },
        params: {produce: produce}
    };

    try {
        const response = await axiosInstance(config);
        return response.data; // Assuming the server returns some data upon success
    } catch (error) {
        // Handle error
        console.error('Error:', error);
        throw error; // Rethrow the error for handling in the calling code
    }
};

// queryByLocation
export const location = async(zipcode, radius) => {
    const config = {
        method: "get",
        url: "/chat/location",
        headers: {
            "Content-Type": "application/json",
        },
        params: {zipcode: zipcode, radius: radius}
    };

    try {
        const response = await axiosInstance(config);
        return response.data; // Assuming the server returns some data upon success
    } catch (error) {
        // Handle error
        console.error('Error:', error);
        throw error; // Rethrow the error for handling in the calling code
    }
};

// queryByProduceAndLocation
export const locationAndProduce = async(produce, zipcode, radius) => {
    const config = {
        method: "get",
        url: "/chat/locationAndProduce",
        headers: {
            "Content-Type": "application/json",
        },
        params: {produce: produce, zipcode: zipcode, radius: radius}
    };

    try {
        const response = await axiosInstance(config);
        return response.data; // Assuming the server returns some data upon success
    } catch (error) {
        // Handle error
        console.error('Error:', error);
        throw error; // Rethrow the error for handling in the calling code
    }
};