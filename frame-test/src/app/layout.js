import "./globals.css";
import { Providers } from "./providers";

export default function MainContent() {
    return (<></>);
}

export default function RootLayout({ children }) {
    return (
        <html lang="ko">
            <body
                className={`${geistSans.variable} ${geistMono.variable} antialiased`}
            >
                <Providers>
                    <MainContent>
                        {children}
                    </MainContent>
                </Providers>
            </body>
        </html>
    );
}
