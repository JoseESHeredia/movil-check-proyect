import React, { useState, useEffect } from 'react';

const AdminTiendas = () => {
    const [tiendas, setTiendas] = useState([]);
    const [nuevaTienda, setNuevaTienda] = useState({ nombre: '', urlWeb: '' });

    // Cargar las tiendas al iniciar
    useEffect(() => {
        fetchTiendas();
    }, []);

    const fetchTiendas = async () => {
        try {
            const response = await fetch('http://localhost:8080/api/admin/tiendas');
            const data = await response.json();
            setTiendas(data);
        } catch (error) {
            console.error("Error cargando tiendas:", error);
        }
    };

    const handleAgregar = async (e) => {
        e.preventDefault();
        try {
            await fetch('http://localhost:8080/api/admin/tiendas', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(nuevaTienda)
            });
            setNuevaTienda({ nombre: '', urlWeb: '' });
            fetchTiendas(); // Recargar la lista
        } catch (error) {
            console.error("Error al agregar:", error);
        }
    };

    const handleEliminar = async (id) => {
        if (window.confirm("¿Seguro que quieres quitar esta tienda?")) {
            await fetch(`http://localhost:8080/api/admin/tiendas/${id}`, { method: 'DELETE' });
            fetchTiendas();
        }
    };

    return (
        <div style={{ padding: '20px' }}>
            <h2>Panel de Control: Tiendas Relacionadas</h2>
            
            {/* Formulario para agregar */}
            <form onSubmit={handleAgregar} style={{ marginBottom: '20px' }}>
                <input 
                    type="text" 
                    placeholder="Nombre (Ej: Claro)" 
                    value={nuevaTienda.nombre}
                    onChange={(e) => setNuevaTienda({...nuevaTienda, nombre: e.target.value})}
                    required 
                />
                <input 
                    type="text" 
                    placeholder="URL Web" 
                    value={nuevaTienda.urlWeb}
                    onChange={(e) => setNuevaTienda({...nuevaTienda, urlWeb: e.target.value})}
                    required 
                />
                <button type="submit">Agregar Tienda</button>
            </form>

            {/* Tabla de listado */}
            <table border="1" cellPadding="10" style={{ width: '100%', borderCollapse: 'collapse' }}>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>URL</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    {tiendas.map(t => (
                        <tr key={t.idTienda}>
                            <td>{t.nombre}</td>
                            <td>{t.urlWeb}</td>
                            <td>{t.activo ? '✅ Activo' : '❌ Inactivo'}</td>
                            <td>
                                <button onClick={() => handleEliminar(t.idTienda)} style={{ color: 'red' }}>Quitar</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default AdminTiendas;
