import { useState } from 'react'
import './App.css'
import Header from './Components/Header'
import Home from './Components/Home'
import Footer from './Components/Footer'

function App() {

  return (
    <>
      <Header/>
      {/*instalar para poder importar <Routes> */}
      <Home/>
      {/* </Routes> */}
      <Footer/>    
    </>
  )
}

export default App
