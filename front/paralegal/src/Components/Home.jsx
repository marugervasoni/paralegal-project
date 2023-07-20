import React from 'react'
import "../styles.modules/home.css"

const Home = () => {
  return (
    <div className='home'>
        <h1 className='titulo'>Herramientas</h1>
        <section>
            <li>
                <ul>Expedientes</ul>
                <ul>Juzgados</ul>
                <ul>Audiencias</ul>
                <ul>Clientes</ul>
                <ul>Recordatorios</ul>
            </li>
        </section>
    </div>
  )
}

export default Home