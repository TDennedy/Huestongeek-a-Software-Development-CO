import { React, useState, useEffect } from 'react';
import { Link, NavLink } from 'react-router-dom';
import { SiRedwoodjs } from 'react-icons/si';
import { MdOutlineCancel } from 'react-icons/md';
import { TooltipComponent } from '@syncfusion/ej2-react-popups';
import { SiOpenstreetmap } from 'react-icons/si';

import { links } from '../data/dummy';
import { useStateContext } from '../contexts/ContextProvider';

import TrailInfo from './Map/TrailInfo'
import { getOxfordTrails } from "./Map/Requests.js"


const Sidebar = () => {
  const { currentColor, activeMenu, setActiveMenu, screenSize } = useStateContext();

  const handleCloseSideBar = () => {
    if (activeMenu !== undefined && screenSize <= 900) {
      setActiveMenu(false);
    }
  };

  const activeLink = 'flex items-center gap-5 pl-4 pt-3 pb-2.5 rounded-lg  text-white  text-md m-2';
  const normalLink = 'flex items-center gap-5 pl-4 pt-3 pb-2.5 rounded-lg text-md text-gray-700 dark:text-gray-200 dark:hover:text-black hover:bg-light-gray m-2';


  const [ data, setData ] = useState(null);
	useEffect(() => {
		const getData = async () => {
			const resp = await getOxfordTrails();
			setData(await resp.json());
		}

		getData();
	}, [data]);

  return (
    <div className="ml-3 h-screen md:overflow-hidden overflow-auto md:hover:overflow-auto pb-10">
      {activeMenu && (
        <>
          <div className="flex justify-between items-center">
            {/* LOGO and TITLE */}
            <Link to="/" onClick={handleCloseSideBar} className="items-center gap-3 ml-3 mt-4 flex text-xl font-extrabold tracking-tight dark:text-white text-slate-900">
              <SiRedwoodjs /> <span>Hueston Geek</span>
            </Link>

            {/* SIDEBAR CLOSING BUTTON */}
            <TooltipComponent content="Menu" position="BottomCenter">
              <button
                type="button"
                onClick={() => setActiveMenu(!activeMenu)}
                style={{ color: currentColor }}
                className="text-xl rounded-full p-3 hover:bg-light-gray mt-4 block md:hidden"
              >
                <MdOutlineCancel />
              </button>
            </TooltipComponent>
          </div>

          <div className="mt-10 ">
            {links.map((item) => (
              <div key={item.title}>
                <p className="text-gray-400 dark:text-gray-400 m-3 mt-4 uppercase">
                  {item.title}
                </p>
                {item.links.map((link) => (
                  <NavLink
                    to={`/${link.name}`}
                    key={link.name}
                    onClick={handleCloseSideBar}
                    style={({ isActive }) => ({
                      backgroundColor: isActive ? currentColor : '',
                    })}
                    className={({ isActive }) => (isActive ? activeLink : normalLink)}
                  >
                    {link.icon}
                    <span className="capitalize ">{link.name}</span>
                  </NavLink>
                ))}
              </div>
            ))}

            <TrailInfo data={data}/>
          </div>

          {/* <div className="mt-10 ">
            <div key = "Map">
              <p className="text-gray-400 dark:text-gray-400 m-3 mt-4 uppercase">
                  Map
              </p>
              <NavLink
                // Take an eye to this point, which cause error
                to="/"
                //
                key="Map"
                onClick={handleCloseSideBar}
                style={({ isActive }) => ({
                  backgroundColor: isActive ? currentColor : '',
                })}
                className={({ isActive }) => (isActive ? activeLink : normalLink)}
              >
                <SiOpenstreetmap />
                <span className="capitalize ">Map</span>
              </NavLink>
            </div>
          </div> */}
        </>
      )}
    </div>
  );
};

export default Sidebar;