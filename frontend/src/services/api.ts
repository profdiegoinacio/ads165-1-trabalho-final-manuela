export async function fetchUsuarios() {
    const res = await fetch('http://localhost:8080/api/v1/usuarios', {
        cache: 'no-store' // Evita cache no SSR
    });
    if (!res.ok) {
        throw new Error('Erro ao buscar usuários');
    }
    return res.json();
}
