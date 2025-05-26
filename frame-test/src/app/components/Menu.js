"use client"

import { setSelectedMenu } from '@/redux/menuSlice';
import { useRouter } from 'next/navigation';
import React from 'react';
import { useDispatch, useSelector } from 'react-redux';

const Menu = () => {
    const dispatch = useDispatch();
    const { menus } = useSelector((state) => {
        return state.menu;
    });
    const router = useRouter();

    const handleMenuClick = (menu) => {
        dispatch(setSelectedMenu(menu.path)); // 이때 매개변수가 action에 들어갈 값
        router.push(menu.path);
    }


    return (
        <nav>
            <ul>
                {menus.map((menu) => {
                    <li
                        key={menu.path}
                        onClick={() => { handleMenuClick(menu) }}>
                        {menu.name}
                    </li>
                })}
            </ul>
        </nav>
    );
}

export default Menu;