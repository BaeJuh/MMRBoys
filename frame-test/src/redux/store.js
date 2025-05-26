import { configureStore } from "@reduxjs/toolkit";
import menuReducer from "./menuSlice";
import memberReducer from "./memberSlice";

export const store = configureStore({
    reducer: {
        menu: menuReducer,
        member: memberReducer
    }
});