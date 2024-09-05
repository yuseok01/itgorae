import { NextApiHandler, NextApiRequest, NextApiResponse } from "next";
//호출하면 '/' 새로 생성
export default async function handler(
    req:NextApiRequest,
    res:NextApiResponse
)  {
    try{
        await res.revalidate ('/')
        return res.json({revalidate: true});

    }catch (err){
        res.status(500).send("Revalidation Failed")
    }
}