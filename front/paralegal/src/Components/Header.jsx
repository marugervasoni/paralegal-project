import React from 'react'
import "../styles.modules/header.css";

const Header = () => {
  return (
    <div className='header'>
        <h2>Bienvenido a tu asistente jurídico virtual</h2>
        <img className='logo' src="/src/assets/logoSBorde.svg" alt="logo"/>
    </div>
  )
}

export default Header