import React, { createContext, useContext, useState } from 'react';

import keycloak from '../KeyCloak';

const StateContext = createContext();

const initialState = {
  chat: false,
  cart: false,
  userProfile: false,
  notification: false,
};

export const ContextProvider = ({ children }) => {
  const [screenSize, setScreenSize] = useState(undefined);
  const [currentColor, setCurrentColor] = useState('#03C9D7');
  const [currentMode, setCurrentMode] = useState('Light');
  const [themeSettings, setThemeSettings] = useState(false);
  const [activeMenu, setActiveMenu] = useState(true);
  const [isClicked, setIsClicked] = useState(initialState);

  // State variable for setting the state of app (logged in/logged out)
  const [appState, setAppState] = useState({ keycloak: null })

  const setMode = (e) => {
    setCurrentMode(e.target.value);
    localStorage.setItem('themeMode', e.target.value);
  };

  const setColor = (color) => {
    setCurrentColor(color);
    localStorage.setItem('colorMode', color);
  };

  const handleClick = (clicked) => setIsClicked({ ...initialState, [clicked]: true });


  const logout = () => {
    keycloak.logout()
    setAppState({ keycloak: null })
  }

  return (
    // eslint-disable-next-line react/jsx-no-constructed-context-values
    <StateContext.Provider value={{ currentColor, currentMode, activeMenu,
                                    screenSize, setScreenSize, handleClick,
                                    isClicked, initialState, setIsClicked,
                                    setActiveMenu, setCurrentColor, setCurrentMode, setMode,
                                    setColor, themeSettings, setThemeSettings,
                                    appState, setAppState, logout }}>
      {children}
    </StateContext.Provider>
  );
};

export const useStateContext = () => useContext(StateContext);