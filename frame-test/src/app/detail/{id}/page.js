import { useParams } from "next/navigation";

export default function DetailPage() {
    const params = useParams();

    return (
        <div>
            <h1>
                {params.id}번 회원 정보
            </h1>
            <p>
                ID: 
            </p>
        </div>
    );
}