import React, { useState, useEffect } from 'react'

function App() {
  const [equipos, setEquipos] = useState([]);

  useEffect(() => {
    // Aquí llamamos al Servlet de Java que creamos
    fetch('/api/equipos')
      .then(response => response.json())
      .then(data => setEquipos(data))
      .catch(error => console.error('Error al cargar equipos:', error));
  }, []);

  return (
    <div style={{ display: 'flex', minHeight: '100vh', flexDirection: 'column', fontFamily: 'Arial' }}>
      {/* Franja Negra para Móvil - Basado en tu diagrama */}
      <header style={{ backgroundColor: 'black', color: 'white', padding: '15px', textAlign: 'center' }}>
        <strong>Móvil-Check</strong> | {equipos.length > 0 ? `Viendo ${equipos[0].modelo}` : 'Detectando equipo...'}
      </header>

      <div style={{ display: 'flex', flex: 1 }}>
        {/* Barra Lateral - Especificaciones Técnicas */}
        <aside style={{ width: '260px', backgroundColor: '#f8f9fa', padding: '20px', borderRight: '1px solid #dee2e6' }}>
          <h3>Tu Equipo Actual</h3>
          {equipos.length > 0 ? (
            <ul style={{ list-style: 'none', padding: 0 }}>
              <li><strong>RAM:</strong> {equipos[0].ram} GB</li>
              <li><strong>CPU:</strong> Octa-core</li>
              <li><strong>Batería:</strong> {equipos[0].bateria} mAh</li>
            </ul>
          ) : <p>Cargando datos...</p>}
        </aside>

        {/* Contenido Principal - Ofertas de Azure SQL */}
        <main style={{ flex: 1, padding: '30px' }}>
          <h2>Mejores Ofertas del Día</h2>
          <div style={{ display: 'grid', gap: '20px' }}>
            {equipos.map(equipo => (
              <div key={equipo.id} style={{ border: '1px solid #ddd', padding: '15px', borderRadius: '8px' }}>
                <h4>{equipo.marca} {equipo.modelo}</h4>
                <p>Almacenamiento: {equipo.almacenamiento}GB | Cámara: {equipo.camara}MP</p>
                <button style={{ backgroundColor: '#0078d4', color: 'white', border: 'none', padding: '10px 15px', borderRadius: '4px', cursor: 'pointer' }}>
                  Ver Mejor Oferta
                </button>
              </div>
            ))}
          </div>
        </main>
      </div>
    </div>
  )
}

export default App
