import './globals.css';
import type { Metadata } from 'next';
import { Inter } from 'next/font/google';
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';

const inter = Inter({ subsets: ['latin'] });

export const metadata: Metadata = {
    title: 'Conecta Voluntário',
    description: 'Plataforma fofa de conexão entre voluntários e ONGs',
};

export default function RootLayout({
                                       children,
                                   }: {
    children: React.ReactNode
}) {
    return (
        <html lang="pt-br">
        <body className={`${inter.className} bg-purple-50 text-gray-800 min-h-screen flex flex-col`}>
        <Navbar />
        <main className="flex-grow p-6">{children}</main>
        <Footer />
        </body>
        </html>
    );
}
