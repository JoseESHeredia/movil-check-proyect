import React from 'react'

function App() {
  return (
    <div style={{ display: 'flex', minHeight: '100vh', flexDirection: 'column' }}>
      {/* Franja Negra para Móvil (Oculta en PC por lógica de diseño) */}
      <header style={{ backgroundColor: 'black', color: 'white', padding: '10px', textAlign: 'center' }}>
        Móvil-Check | Equipo Actual: Detectando...
      </header>

      <div style={{ display: 'flex', flex: 1 }}>
        {/* Barra Lateral para PC */}
        <aside style={{ width: '250px', backgroundColor: '#f4f4f4', padding: '20px', borderRight: '1px solid #ddd' }}>
          <h3>Especificaciones</h3>
          <ul>
            <li>RAM: --</li>
            <li>CPU: --</li>
            <li>Batería: --</li>
          </ul>
        </aside>

        {/* Contenido Principal (Buscador y Ofertas) */}
        <main style={{ flex: 1, padding: '20px' }}>
          <h1>Buscador Inteligente de Equipos</h1>
          <p>Aquí se mostrarán las ofertas del día de la tabla Ofertas_Dia.</p>
        </main>
      </div>
    </div>
  )
}

export default App
