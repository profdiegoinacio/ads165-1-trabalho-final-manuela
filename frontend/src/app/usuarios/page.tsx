import { fetchUsuarios } from "@/services/api";

type Usuario = {
    id: number;
    nome: string;
    email: string;
    tipo: "VOLUNTARIO" | "ONG";
};

export default async function UsuariosPage() {
    const usuarios: Usuario[] = await fetchUsuarios();

    const voluntarios = usuarios.filter(u => u.tipo === "VOLUNTARIO");
    const ongs = usuarios.filter(u => u.tipo === "ONG");

    return (
        <main className="p-8">
            <h1 className="text-3xl font-bold text-purple-600 mb-6 text-center">
                Usuários Cadastrados 🧸🌼
            </h1>

            <section className="mb-8">
                <h2 className="text-2xl text-rose-500 font-semibold mb-2">Voluntários 💛</h2>
                {voluntarios.length === 0 ? (
                    <p className="text-gray-500">Nenhum voluntário cadastrado.</p>
                ) : (
                    <ul className="space-y-2">
                        {voluntarios.map(usuario => (
                            <li key={usuario.id} className="bg-pink-100 p-4 rounded-xl shadow">
                                <p className="font-bold text-rose-700">{usuario.nome}</p>
                                <p className="text-sm text-gray-700">{usuario.email}</p>
                            </li>
                        ))}
                    </ul>
                )}
            </section>

            <section>
                <h2 className="text-2xl text-yellow-500 font-semibold mb-2">ONGs 🌿</h2>
                {ongs.length === 0 ? (
                    <p className="text-gray-500">Nenhuma ONG cadastrada.</p>
                ) : (
                    <ul className="space-y-2">
                        {ongs.map(usuario => (
                            <li key={usuario.id} className="bg-yellow-100 p-4 rounded-xl shadow">
                                <p className="font-bold text-yellow-700">{usuario.nome}</p>
                                <p className="text-sm text-gray-700">{usuario.email}</p>
                            </li>
                        ))}
                    </ul>
                )}
            </section>
        </main>
    );
}
