import React, { useEffect, useState } from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { FiSettings } from 'react-icons/fi';
import { TooltipComponent } from '@syncfusion/ej2-react-popups';

import { Navbar, Footer, Sidebar, ThemeSettings } from './components';
import { Ecommerce, Orders, Calendar, Employees, Stacked, Pyramid, Customers, Kanban, Line, Area, Bar, Pie, Financial, ColorPicker, ColorMapping, Editor } from './pages';
import './App.css';

import { useStateContext } from './contexts/ContextProvider';

import { initKeycloak, kcinit } from './KeyCloak';
import GoogleMap from './components/GoogleMap';

import HomePage from './components/HomePage';

import MapComponent from './components/Map/GLMap';

// Init keycloak
initKeycloak();

const App = () => {

  const [keycloak, setKeyCloak] = useState()

  // A promise to load the authentication from keycloak
  useEffect(() => {
    kcinit.then(kc => setKeyCloak(kc))
  }, [])
  console.log(keycloak)

  if (keycloak != null && keycloak.authenticated) {
    return (
      <DashBoard keycloak={keycloak} />
    )
  }

  return (<HomePage keycloak={keycloak} />)

};

const DashBoard = ({ keycloak }) => {
  // console.log(keycloak.idTokenParsed)

  // Theme Setter
  const { setCurrentColor, setCurrentMode, currentMode, activeMenu, currentColor, themeSettings, setThemeSettings } = useStateContext();

  // useEffect for settting theme
  useEffect(() => {
    const currentThemeColor = localStorage.getItem('colorMode');
    const currentThemeMode = localStorage.getItem('themeMode');
    if (currentThemeColor && currentThemeMode) {
      setCurrentColor(currentThemeColor);
      setCurrentMode(currentThemeMode);
    }
  }, []);



  // What will be printed to the screen
  return (
    <div className={currentMode === 'Dark' ? 'dark' : ''}>
      <BrowserRouter>
            <div className="flex relative dark:bg-main-dark-bg">
              <div className="fixed right-4 bottom-4" style={{ zIndex: '1000' }}>
                <TooltipComponent
                  content="Settings"
                  position="Top"
                >
                  <button
                    type="button"
                    onClick={() => setThemeSettings(true)}
                    style={{ background: currentColor, borderRadius: '50%' }}
                    className="text-3xl text-white p-3 hover:drop-shadow-xl hover:bg-light-gray"
                  >
                    <FiSettings />
                  </button>

                </TooltipComponent>
              </div>
              {activeMenu ? (
                <div className="w-72 fixed sidebar dark:bg-secondary-dark-bg bg-white ">
                  <Sidebar />
                </div>
              ) : (
                <div className="w-0 dark:bg-secondary-dark-bg">
                  <Sidebar />
                </div>
              )}
              <div
                className={
                  activeMenu
                    ? 'dark:bg-main-dark-bg  bg-main-bg min-h-screen md:ml-72 w-full  '
                    : 'bg-main-bg dark:bg-main-dark-bg  w-full min-h-screen flex-2 '
                }
              >
                <div className="fixed md:static bg-main-bg dark:bg-main-dark-bg navbar w-full ">
                  <Navbar />
                </div>
                <div>
                  {themeSettings && (<ThemeSettings />)}

                  <Routes>
                    {/* dashboard  */}
                    {/* <Route path="/home" element={(<HomePage />)} /> */}
                    <Route index={true}  path="/" element={(<MapComponent />)} />
                    <Route  path="/map" element={(<MapComponent />)} />
                    <Route path="/ecommerce" element={(<Ecommerce />)} />

                    {/* pages  */}
                    <Route path="/orders" element={<Orders />} />
                    <Route path="/employees" element={<Employees />} />
                    <Route path="/customers" element={<Customers />} />

                    {/* apps  */}
                    <Route path="/todo" element={<Kanban />} />
                    <Route path="/diary" element={<Editor />} />
                    <Route path="/calendar" element={<Calendar />} />
                    <Route path="/color-picker" element={<ColorPicker />} />

                    {/* charts  */}
                    <Route path="/line" element={<Line />} />
                    <Route path="/area" element={<Area />} />
                    <Route path="/bar" element={<Bar />} />
                    <Route path="/pie" element={<Pie />} />
                    <Route path="/financial" element={<Financial />} />
                    <Route path="/color-mapping" element={<ColorMapping />} />
                    <Route path="/pyramid" element={<Pyramid />} />
                    <Route path="/stacked" element={<Stacked />} />

                  </Routes>
                </div>
                <Footer />
              </div>
            </div>
      </BrowserRouter>
    </div>
  )
}

export default App;