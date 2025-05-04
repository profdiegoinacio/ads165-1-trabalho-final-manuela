// src/components/UsuarioCard.tsx

type Usuario = {
    id: number;
    nome: string;
    email: string;
    tipo: 'ONG' | 'VOLUNTARIO';
};

export function UsuarioCard({ usuario }: { usuario: Usuario }) {
    return (
        <div className="bg-white p-4 rounded-2xl shadow-md mb-2 border-l-4 border-pink-300">
            <h3 className="text-lg font-bold text-rose-500">{usuario.nome}</h3>
            <p className="text-sm text-purple-700">{usuario.email}</p>
        </div>
    );
}
