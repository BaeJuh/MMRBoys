import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    token: "",
    name: "",
    isLogin: false
}

const memberSlice = createSlice({
    name: "member",
    initialState,
    reducers: {
        setLoginState: (state, action) => {
            state.token = action.payload.token;
            state.name = action.payload.name;
            state.isLogin = true;
        }
    }
});

export const { setLoginState } = memberSlice.actions;
export default memberSlice.reducer;