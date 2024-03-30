import axiosInstance from "./AxiosInstance";

// response.data??

// getCart
export const get = async(cartID) => {
    const config = {
        method: "post",
        url: "/cart/get",
        headers: {
            "Content-Type": "application/json",
        },
        params: {cartID: cartID}
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

// updateCart
export const update = async(cartID, cartItem) => {
    const config = {
        method: "post",
        url: "/cart/update",
        headers: {
            "Content-Type": "application/json",
        },
        params: {cartID: cartID, cartItem: cartItem}
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

// addToCart
export const add = async(cartID, cartItem) => {
    const config = {
        method: "post",
        url: "/cart/add",
        headers: {
            "Content-Type": "application/json",
        },
        params: {cartID: cartID, cartItem: cartItem}
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
