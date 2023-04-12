import React from 'react';
import { useNavigate } from 'react-router-dom'

import { useStateContext } from '../contexts/ContextProvider';

const Button = ({ icon, bgColor, color, bgHoverColor, size, text, borderRadius, width, onClick }) => {
  // const { setIsClicked, initialState } = useStateContext();

  // Get the logged out state
  const { logout } = useStateContext()
  const navigate = useNavigate()  // For navigation

  const handleClick = () => {
    if (onClick) onClick(navigate)
    logout()
  }
  
  return (
    <button
      type="button"
      onClick={handleClick}
      style={{ backgroundColor: bgColor, color, borderRadius }}
      className={` text-${size} p-3 w-${width} hover:drop-shadow-xl hover:bg-${bgHoverColor}`}
    >
      {icon} {text}
    </button>
  );
};

export default Button;