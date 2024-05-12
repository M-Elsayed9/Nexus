import React from 'react';
import { FaShoppingCart, FaUserCircle } from 'react-icons/fa';

function NavBar() {
    return (
        <>
            <div className="flex justify-between items-center px-4 py-4 sticky top-0 bg-gray-900 rounded-lg border-2 border-gray-700 m-2 shadow-md">
                <div className="flex items-center">
                    <img className="w-16 h-12 rounded" src="../src/assets/Nexus_Logo.png" alt="Nexus Logo" />
                    <h1 className="text-4xl font-semibold text-white mx-10">NEXUS</h1>
                </div>

                <div className="flex justify-end items-center">
                    <button class="cursor-pointer mx-2 transition-all bg-blue-500 text-white px-6 py-2 rounded-lg border-blue-600 border-b-[4px] hover:brightness-110 hover:-translate-y-[1px] hover:border-b-[6px] active:border-b-[2px] active:brightness-90 active:translate-y-[2px]">
                        Home
                    </button>

                    <button class="cursor-pointer mx-2 transition-all bg-blue-500 text-white px-6 py-2 rounded-lg border-blue-600 border-b-[4px] hover:brightness-110 hover:-translate-y-[1px] hover:border-b-[6px] active:border-b-[2px] active:brightness-90 active:translate-y-[2px]">
                        Co-Working Spaces
                    </button>

                    <button className="text-white cursor-pointer hover:bg-gray-400 p-2 rounded" aria-label="Cart">
                        <FaShoppingCart className="h-7 w-7" />
                    </button>

                    <button className="text-white cursor-pointer mx-2 hover:bg-gray-400 p-2 rounded-lg ">
                        <FaUserCircle className="h-7 w-7" />
                    </button>
                </div>
            </div>
        </>
    )
}

export default NavBar;
