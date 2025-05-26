import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    menus: [
        {name: "대시보드", path: "/", isActive: true},
        {name: "테스트", path: "/test", isActive: false},
    ],
    selectedMenu: "/"
}

const menuSlice = createSlice({
    name: "menu", // menuSlice 관리한다는 뜻
    initialState, // 관리할 값
    reducers: {
        setSelectedMenu: (state, action) => { // action 정의
            state.selectedMenu = action.payload; // "/test"로 값 변경
            state.menus.forEach((menu) => {
                menu.isActive = menu.path === action.payload;
            });
        }
    }
});

export const { setSelectedMenu } = menuSlice.actions;
export default menuSlice.reducer;

// createSlice가 actions와 reducer를 반환