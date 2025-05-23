import { useState } from "react";
import axios from "axios";

interface Card {
    name: string;
    imgName: string;
    means: string[];
    selected?: boolean;
}

const cards: Card[] = [
    { name: '1월', imgName: '1.jpg', means: ['소식', '손님', '남자'] },
    { name: '2월', imgName: '2.jpg', means: ['님', '여자'] },
    { name: '3월', imgName: '3.jpg', means: ['외출', '혼란', '만남'] },
    { name: '4월', imgName: '4.jpg', means: ['싸움', '무관심'] },
    { name: '5월', imgName: '5.jpg', means: ['결혼', '이성'] },
    { name: '6월', imgName: '6.jpg', means: ['기쁨', '호감'] },
    { name: '7월', imgName: '7.jpg', means: ['행운', '돈'] },
    { name: '8월', imgName: '8.jpg', means: ['어둠', '저녁'] },
    { name: '9월', imgName: '9.jpg', means: ['술'] },
    { name: '10월', imgName: '10.jpg', means: ['근심', '풍파', '바람'] },
    { name: '11월', imgName: '11.jpg', means: ['돈', '복'] },
    { name: '12월', imgName: '12.jpg', means: ['손님', '눈물'] },
];

export default function Hwatu() {
    const [mixCards, setMixCards] = useState<Card[]>([]);
    const [pickCards, setPickCards] = useState<Card[]>([]);
    const [response, setResponse] = useState<string>("");
    const [isLoading, setIsLoading] = useState<boolean>(false);

    // 카드 섞기
    const handleMixCards = (): void => {
        const shuffled = [...cards]
            .map(card => ({ ...card, selected: false }))
            .sort(() => Math.random() - 0.5);
        setMixCards(shuffled);
        setPickCards([]);
        setResponse("");
    };

    // 카드 선택
    const handlePickCard = (cardName: string): void => {
        if (pickCards.length >= 2) {
            alert("최대 두 장의 카드만 선택할 수 있습니다.");
            return;
        }
        const updatedCards = mixCards.map(card =>
            card.name === cardName ? { ...card, selected: true } : card
        );
        const selectedCard = updatedCards.find(card => card.name === cardName);
        setMixCards(updatedCards);
        if (selectedCard) {
            setPickCards([...pickCards, selectedCard]);
        }
    };

    // 다시하기 (초기화)
    const handleReset = (): void => {
        setMixCards([]);
        setPickCards([]);
        setResponse("");
    };

    // AI 운세 요청
    const handleConfirm = async (): Promise<void> => {
        if (pickCards.length === 2) {
            setIsLoading(true);
            const means = pickCards.flatMap((card: Card) => card.means).join(", ");
            const command = `너는 점을 봐주는 점쟁이야. ${means} 키워드로 운세를 5줄 내외의 문장으로 만들어줘.`;

            const API_KEY: string = import.meta.env.REACT_APP_GEMINI_API_KEY;
            const apiUrl = `https://generativelanguage.googleapis.com/v1/models/gemini-1.5-flash:generateContent?key=${API_KEY}`;
            const data = { "contents": [{ "parts": [{ "text": command }] }] };

            try {
                const res = await axios.post(apiUrl, data);
                const generatedText = res.data.candidates?.[0]?.content?.parts?.[0]?.text || "응답을 가져올 수 없습니다.";
                setResponse(generatedText);
            } catch (err) {
                setResponse(`API 콜 실패 ${err}`);
            } finally {
                setIsLoading(false);
            }
        }
    };

    return (
        <div>
            {mixCards.length === 0 ? (
                <button onClick={handleMixCards}>카드섞기</button>
            ) : (
                <div>
                    <h1>카드를 선택하세요</h1>
                    {mixCards.map((card: Card) => (
                        <div
                            key={card.name}
                            onClick={() => handlePickCard(card.name)}
                            style={{
                                border: card.selected ? "2px solid red" : "none",
                                display: "inline-block",
                                margin: "5px",
                                cursor: "pointer"
                            }}
                        >
                            {card.selected ? (
                                <div>
                                    <img src={`/images/${card.imgName}`} alt={card.name} />
                                    <p>{card.name}</p>
                                </div>
                            ) : (
                                <div>
                                    <img src={`/images/back.jpg`} alt="back" />
                                </div>
                            )}
                        </div>
                    ))}
                    {pickCards.length === 2 && (
                        <div>
                            <button onClick={handleConfirm}>운세보기</button>
                            <button onClick={handleReset}>다시하기</button>
                            {isLoading && <p>운세를 가져오는 중...</p>}
                            {response && <p>{response}</p>}
                        </div>
                    )}
                </div>
            )}
        </div>
    );
}