import axiosInstance from "./AxiosInstance";

// get chat
export const get = async(customerID, farmerID) => {
    const config = {
        method: "get",
        url: "/chat/get",
        headers: {
            "Content-Type": "application/json",
        },
        params: {customerID: customerID, farmerID: customerID}
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

// getLatest
export const latest = async(chatID, timeStamp) => {
    const config = {
        method: "get",
        url: "/chat/latest",
        headers: {
            "Content-Type": "application/json",
        },
        params: {chatID: chatID, from: timeStamp}
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

// sendMessage
export const send = async(messageID, senderID, content, sentAt) => {
    const config = {
        method: "post",
        url: "/chat/send",
        headers: {
            "Content-Type": "application/json",
        },
        data: {message: {messageId: messageID, senderId: senderID, content: content, sentAt: sentAt}}
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

// finishConversation
export const end = async(chatID) => {
    const config = {
        method: "post",
        url: "/chat/end",
        headers: {
            "Content-Type": "application/json",
        },
        params: {chatId: chatID}
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
