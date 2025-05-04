'use client';

import Link from 'next/link';

export default function Navbar() {
    return (
        <nav className="bg-pink-100 text-purple-700 p-4 shadow-md flex justify-between items-center rounded-b-2xl">
            <h1 className="text-xl font-bold">🌸 Conecta Voluntário</h1>
            <div className="flex gap-4">
                <Link href="/" className="hover:text-yellow-500">Início</Link>
                <Link href="/usuarios" className="hover:text-yellow-500">Nossos colaboradores</Link>
            </div>
        </nav>
    );
}
